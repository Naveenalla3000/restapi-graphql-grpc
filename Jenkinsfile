pipeline {
    agent any
    tools {
        maven 'Maven_3_8_6'
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
