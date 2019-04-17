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
     sh 'docker build -t javaminiature/helloworldcicd .'
     echo 'Building docker image done'
   }
   
   stage('Push Docker Image'){
     withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerHubPwd')]) {
        sh "docker login -u miniature -p Welcome123"
     }
     sh 'docker push javaminiature/helloworldcicd'
     echo 'Push Docker Image'
   }
}