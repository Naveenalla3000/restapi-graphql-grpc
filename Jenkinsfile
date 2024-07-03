pipeline {
    agent any
    tools {
        maven 'Maven_3_9_8'
    }
    stages {
        stage("init") {
            steps {
                echo 'Initializing...'
            }
        }
        stage("version") {
            steps {
                sh 'mvn --version'
            }
        }
        stage("clean") {
            steps {
                sh 'mvn clean'
            }
        }
        stage("test") {
            steps {
                sh 'mvn test'
            }
        }
        stage("package") {
            steps {
                sh 'mvn package'
            }
        }
        stage("docker") {
            steps {
                sh 'docker build -t jenkins-demo .'
            }
        }
    }
    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
