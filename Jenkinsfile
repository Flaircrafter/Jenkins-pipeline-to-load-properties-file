pipeline {
    agent any

    environment {
    	artifactory = credentials("testing")
    }

    stages {

    	stage ('Load Properties file') {
      		steps {
        		script {
          			load 'build.properties'
          			echo "Inside===========${appname}"
        		}
      		}
    	}

        stage ('prepare') {
            steps {
                script {
                      echo "Outside===========${appname}"
                  }
            }
        }

        stage ('Checking variables') {
            steps {
                script {
                         
                	  //env.place = place
    				  sh 'echo "The user is ${env.artifactory_USR}"'
                       
                      
                  }
            }
        }
    }
 }
