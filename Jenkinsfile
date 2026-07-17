pipeline {
    agent any

    tools {
        jdk 'JDK'
        maven 'Maven3'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t skillsphere-backend .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker rm -f skillsphere-app || exit 0'
                bat 'docker run -d -p 8083:8082 --name skillsphere-app skillsphere-backend'
            }
        }
    }
}