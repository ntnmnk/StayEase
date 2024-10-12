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
                    // Navigate to the cloned repository directory and build the project
                    bat 'cd C:\\deploy\\StayEase && gradle clean build'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Find the JAR file in the build/libs directory
                    def jarFile = bat(script: 'dir /B C:\\deploy\\StayEase\\build\\libs\\*.jar', returnStdout: true).trim()

                    // Deploy your application using the found JAR file
                    bat "java -jar C:\\deploy\\StayEase\\build\\libs\\${jarFile}"
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
