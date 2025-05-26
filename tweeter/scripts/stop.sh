#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/tweeter"
JAR_FILE="$PROJECT_ROOT/tweeter-0.0.1-SNAPSHOT.jar"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"
TIME_NOW=$(date +%c)

echo "$TIME_NOW > stop.sh 시작" >> $DEPLOY_LOG

# TweeterApplication 프로세스 확인
CURRENT_PIDS=$(ps aux | grep "java -jar $JAR_FILE" | grep -v grep | awk '{print $2}')

if [ -z "$CURRENT_PIDS" ]; then
  echo "$TIME_NOW > 현재 실행 중인 애플리케이션이 없습니다." >> $DEPLOY_LOG
else
  echo "$TIME_NOW > 종료할 PID들: $CURRENT_PIDS" >> $DEPLOY_LOG
  for PID in $CURRENT_PIDS; do
    echo "$TIME_NOW > PID $PID 종료 시도" >> $DEPLOY_LOG
    kill -15 $PID
  done

  # 종료 대기 및 강제 종료
  for i in {1..12}; do
    sleep 5
    STILL_RUNNING=$(ps -p $CURRENT_PIDS | grep -v "PID")
    if [ -z "$STILL_RUNNING" ]; then
      echo "$TIME_NOW > 프로세스 종료 완료" >> $DEPLOY_LOG
      break
    fi
    echo "$TIME_NOW > 아직 종료 안된 프로세스: $STILL_RUNNING" >> $DEPLOY_LOG
  done

  # 최종 강제 종료
  for PID in $CURRENT_PIDS; do
    if ps -p $PID > /dev/null; then
      echo "$TIME_NOW > PID $PID 강제 종료" >> $DEPLOY_LOG
      kill -9 $PID
    fi
  done
fi

echo "$TIME_NOW > stop.sh 종료" >> $DEPLOY_LOG
exit 0
