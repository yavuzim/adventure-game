pipeline {
    agent any

    environment {
        GIT_CREDENTIALS = 'e7b24fa9-75dc-4e83-99a8-1e14a4570359'
        DEPLOY_SERVER = 'john@192.168.1.100'       // Sunucu kullanıcı adı ve IP adresi
        DEPLOY_PATH = '/var/www/html'              // Dağıtım yapılacak dizin
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                    credentialsId: env.GIT_CREDENTIALS, 
                    url: 'https://github.com/yavuzim/adventure-game.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                sh "scp -r target/* ${DEPLOY_SERVER}:${DEPLOY_PATH}"  // Maven build çıktısını sunucuya kopyalar
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed!'
        }
    }
}
