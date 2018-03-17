# AWS lambda / serverless / java 8 / gradle / sample

[Install npm (Debian) for serverless](https://nodejs.org/en/download/package-manager/)
```bash
curl -sL https://deb.nodesource.com/setup_8.x | sudo -E bash -
sudo apt-get install -y nodejs
npm install serverless

serverless login
serverless config credentials --provider aws --key $SERVERLESS_KEY --secret $SERVERLESS_SECRET
```

Create project
```bash
cd ~/source/
serverless create --template aws-java-gradle --path aws-lambda-sample
cd aws-lambda-sample
```

Build project
```bash
./gradlew build
```

Deploy project
```bash
serverless deploy --stage dev
serverless remove --stage dev
```


