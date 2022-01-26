pipeline {
    agent { label 'Linux_Default' }
    tools {
        maven 'Maven 3.3.9'
        jdk 'JDK_1.8_121_Linux'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                withMaven(maven: 'Maven 3.3.9', mavenSettingsConfig: 'f5933f81-0452-4148-a6a9-8a3e05ebf361') {
                    sh 'mvn -Dmaven.test.failure.ignore=true verify'
                }
            }
            post {
                success {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}
