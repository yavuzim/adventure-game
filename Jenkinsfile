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
               echo "Checkout kısmı çalıştı!"
            }
        }

        stage('Build') {
            steps {
                echo "Build kısmı çalıştı!"
            }
        }

        stage('Test') {
            steps {
               echo "Test kısmı çalıştı!"
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy kısmı çalıştı!"
            }
        }
    }

    post {
        always {
            echo 'Pipeline tamamlandı!!!!!!!'
        }
    }
}
