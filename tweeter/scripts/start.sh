#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/tweeter"
JAR_FILE="$PROJECT_ROOT/tweeter-0.0.1-SNAPSHOT.jar"
APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"
TIME_NOW=$(date "+%Y-%m-%d %H:%M:%S")

# 빌드 파일 복사
echo "$TIME_NOW > JAR 파일 복사 시작" >> $DEPLOY_LOG
if ls $PROJECT_ROOT/build/libs/*.jar 1> /dev/null 2>&1; then
    cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE
    echo "$TIME_NOW > JAR 파일 복사 완료" >> $DEPLOY_LOG
else
    echo "$TIME_NOW > 빌드 파일 없음, 복사 생략" >> $DEPLOY_LOG
fi

# JAR 파일 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
cd $PROJECT_ROOT
nohup java -jar tweeter-0.0.1-SNAPSHOT.jar > $APP_LOG 2> $ERROR_LOG < /dev/null &

CURRENT_PID=$(pgrep -f "java -jar tweeter-0.0.1-SNAPSHOT.jar")
echo "$TIME_NOW > 실행된 프로세스의 PID는 $CURRENT_PID 입니다." >> $DEPLOY_LOG
