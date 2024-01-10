pipeline {
 agent {label 'prod'}
    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker')
	}
    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code repository
                git branch: 'main', url: 'https://github.com/mbaykara/spring-cloud-kubernetes.git'
            }
        }
        
        stage('Build') {
            steps {
                // Run Maven build
                sh 'mvn compile jib:build -Djib.to.tags=k8s' // Or any other Maven commands you need
            }
            post {
                success {
                    // Actions to perform after a successful build
                    echo 'Maven build successful!'
                    // You can add additional steps like archiving artifacts, publishing reports, etc.
                }
                failure {
                    // Actions to perform if the build fails
                    echo 'Maven build failed!'
                    // You can add notifications or any cleanup steps here
                }
            }
        }
    }
    
    // You can add more stages for testing, deployment, etc.
    
    // Optional: Define post-build actions, notifications, etc.
    post {
        always {
            // Cleanup steps that should always run
            echo 'Build finished, performing cleanup...'
            // You can add post-build actions here
        }
    }
}
