node {
   def mvnHome
   stage('Preparation') { 
      git 'https://github.com/javaminiature/helloworld_cicd.git'
      mvnHome = tool 'M3'
   }
   stage('Build') {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
     }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
   }
  
   stage('Build Docker Image'){
     sh 'docker build -t miniature/helloworldcicd .'
     echo 'Building docker image done'
   }
   
   stage('Push Docker Image'){
     echo 'Push Docker Image'
     withCredentials([usernamePassword (credentialsId: 'docker-hub-credentials',  usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker login -u $USERNAME -p $PASSWORD"
		sh "docker push miniature/helloworldcicd"
     }     
     echo 'Push Docker Image Done'
   }
}