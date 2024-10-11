
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ntnmnk/StayEase.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build -x test' // Skip tests
            }
        }
        stage('Package') {
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    def jarFile = 'build/libs/*.jar'
                    // Use the correct path for pscp.exe
                    bat "C:\\ProgramData\\chocolatey\\bin\\pscp.exe ${jarFile} Administrator@192.168.140.215:C:\\"
                }
            }
        }
    }
    post {
        success {
            echo 'Build and Deploy succeeded!'
        }
        failure {
            echo 'Build or Deploy failed!'
        }
    }
}
