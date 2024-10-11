pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ntnmnk/StayEase.git'
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
                    // Find the jar file
                   def jarFile = sh(script: "ls build/libs/*.jar", returnStdout: true).trim()
bat "C:\\ProgramData\\chocolatey\\bin\\pscp.exe -pw Sanfran@883097 ${jarFile} Administrator@192.168.140.215:C:\\"

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
