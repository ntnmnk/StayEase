pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/ntnmnk/StayEase.git', branch: 'main'
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
                    // Define the path to the jar file and the deployment directory
                    def jarFile = 'build/libs/*.jar'
                    def deployDir = "C:\\deploy\\StayEase"

                    // Copy the jar to the deployment directory
                    bat "if not exist ${deployDir} mkdir ${deployDir} && copy /Y ${jarFile} ${deployDir}"

                    // Run the jar
                    bat "start cmd /c java -jar ${deployDir}\\${jarFile.split('/').last()}"
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
