node {
   stage('Git Checkout'){
       git credentialsId: 'GIT', url: 'https://github.com/javaminiature/helloworld_cicd'
       echo 'Checkout complete'
   }
   
   stage('Maven Package'){
     def mvnHome = tool name: 'M3', type: 'maven'
     def mvnCMD = "${mvnHome}/bin/mvn"
     sh "${mvnCMD}  clean package"
     echo 'Mvn Package complete'
   }
   
   stage('Build Docker Image'){
     sh 'docker build -t javaminiature/helloworldcicd .'
     echo 'Building docker image done'
   }
 }