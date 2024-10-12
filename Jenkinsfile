pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                script {
                    // Change to the C:\ directory before cloning
                    bat 'cd C:\\deploy\\ && git clone https://github.com/ntnmnk/StayEase.git'
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    // Navigate to the cloned repository directory
                    bat 'cd C:\\deploy\\StayEase && ./gradlew build clean'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Deploy your application (modify according to your needs)
                    bat 'cd C:\\StayEase\\target && java -jar your-app.jar'
                }
            }
        }
        stage('Run Background Process') {
            steps {
                script {
                    // Run a command in the background (PowerShell example)
                    bat 'start /B powershell -Command "echo Background process started; Start-Sleep -Seconds 60; echo Background process completed"'
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
