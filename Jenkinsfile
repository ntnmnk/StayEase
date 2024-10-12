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
                    echo "Found JAR file: ${jarFile}"

                    // Define deployment directory
                    def deployDir = "C:\\deploy\\StayEase"

                    // Copy the jar to the deployment directory
                    bat """
                    if not exist ${deployDir} mkdir ${deployDir}
                    copy /Y ${jarFile} ${deployDir}
                    """
                    
                    // Check the contents of the deployment directory
                    bat "dir ${deployDir}"

                    // Run the jar
                    echo "Running the JAR from path: ${deployDir}\\${jarFile.split('/').last()}"
                    bat "java -jar ${deployDir}\\${jarFile.split('/').last()}"
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
