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
                    // Set the name of the JAR file based on the build.gradle configuration
                    def jarName = 'StayEase-1.0.0.jar' // Update this to your actual JAR name if different
                    
                    // Deploy your application using the built JAR file
                    bat "cd C:\\deploy\\StayEase\\build\\libs && java -jar ${jarName}"
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
