pipeline {

  //agent {
  //  label 'slave1'     //############################## U C  #############################
  //}

  agent any        //############################# R ##############################
 
  environment {
    //ARTIFACTORY = credentials("${ARTIFACTORY}") // Username with password  //############################## U C  #############################
    ARTIFACTORY = credentials("testing")            //############################# R ##############################
    //REGISTRY_ADDRESS = "${REGISTRY_ADDRESS}"
  }

  options {
    timestamps()
    disableConcurrentBuilds()
  }

  stages {
    stage ('Load Properties file') {
      steps {
        script {
          //load 'jenkins-props/build.properties' //############################## U C  #############################
          load 'build.properties'  //############################# R ##############################               
          echo "Inside===========${appname}"    //############################# R ##############################
        }
      }
    }

    stage('Environment check') {
      steps {
        sh label: 'Getting build versions', script: '''
        which git; git --version
        #which gradle; gradle --version          //############################## U C  #############################
        which docker; docker --version
        systemctl status docker;
        uname -a;
        '''
      }
    }

    // stage('Checkout SCM') {
    //   steps {
    //     cleanWs()
    //     checkout scm
    //   }
    // }
    
    // Conditions to set artification version is covered for develop and release branches
    // stage('Set version') {
    //   steps {
    //     script { 
    //       echo "Outside===========${appname}"
    //       def values = env.GIT_BRANCH.tokenize('/')
    //       branchType = values[0] 
    //       branchVersion = values[1]
    //       artifactVersion = (branchType == 'release' ? values[1] : 'DEV-SNAPSHOT')
    //     }
    //   }
    // }

    // stage('docker login and container build') {
    //   steps {
    //     sh "ls -lrt; pwd"
    //     echo 'running docker build'
    //     script {
    //       //withEnv([ARTIFACTORY = credentials("${ARTIFACTORY}")])
    //         echo "==================="
    //         //env.appname = appname
    //         echo "This is ${env.ARTIFACTORY_USR}"
    //         sh "docker build -t ${env.appname}-${env.GIT_COMMIT}:latest --build-arg ARTIFACTORY_ACCOUNT=${env.ARTIFACTORY_USR} --build-arg ARTIFACTORY_TOKEN=${env.ARTIFACTORY_PSW} ."
    //         sh "docker images"

    //         sh """
    //             docker container create --name ${env.appname}-${env.GIT_COMMIT} ${env.appname}-${env.GIT_COMMIT}:latest
    //             docker cp ${env.appname}-${env.GIT_COMMIT}:/app/build/libs ${env.WORKSPACE}/
    //             ls -lrt ${env.WORKSPACE}/
    //         """
    //     }
    //   }
    // }

    // Removing env.GIT_COMMIT, env.GIT_COMMIT was added only to test the CI/CD pipeline changes.
    // stage('Publish artifacts') {
    //   when {
    //     expression {
    //       (branchType == 'develop' || branchType == 'release')
    //     }
    //   } 
    //   steps {
    //     script {
    //       dateTime=$(date +"%Y%m%d%H%M%S")
    //       reponame = (branchType == 'release') ? "${ARTIFACT_REPOSITORY_RELEASE}" : "${ARTIFACT_REPOSITORY_LOCAL}"
    //       targetfilename = "${env.appname}-${artifactVersion}"
    //     }

    //     withCredentials([usernamePassword(
    //       credentialsId: "${ARTIFACTORY}",
    //       usernameVariable: 'username',
    //       passwordVariable: 'password'
    //     )]) {
    //       rtServer(
    //         id: 'ArtifactoryServer',
    //         url: "${ARTIFACTORY_URL}",
    //         username: "$username",
    //         password: "$password",
    //       )

    //       rtUpload(
    //         serverId: 'ArtifactoryServer',
    //         spec: """{
    //               "files": [
    //                 {
    //                   "pattern": "${env.WORKSPACE}/${appname}-(*).jar",
    //                   "target": "${env.reponame}/${env.REPO_PATH}/${env.appname}/${artifactVersion}/${targetfilename}-${dateTime}.jar",
    //                   "props": "businessUnit.name=Fixed-Income;
                      
    //                 },
    //                 {
    //                   "pattern": "${env.WORKSPACE}/scripts/start-${env.appname}.sh",
    //                   "target": "${env.reponame}/${env.REPO_PATH}/${env.appname}/${artifactVersion}/start-${env.appname}.sh",
    //                   "props": "businessUnit.name=Fixed-Income"
    //                 },
    //                 {
    //                   "pattern": "${env.WORKSPACE}/scripts/stop-${env.appname}.sh",
    //                   "target": "${env.reponame}/${env.REPO_PATH}/${env.appname}/${artifactVersion}/stop-${env.appname}.sh",
    //                   "props": "businessUnit.name=Fixed-Income" 
    //                 }
    //               ]
    //             }""",
    //       )

    //       rtPublishBuildInfo(
    //         serverId: 'ArtifactoryServer'
    //       )
    //     }
    //   }
    // }

      
    // stage('Trigger QA deployment') {
    //   when {
    //     expression {
    //       (branchType == 'develop')
    //     }
    //   }
    //   steps {
    //     script {
    //       build job: "${deploy_job_develop}/${env.BRANCH_NAME.replaceAll('/', '%2F')}",
    //       propagate: false,
    //       wait: false
    //     }   
    //   }
    // }

    // stage("Trigger Prod/BC Deployment") {
    //   when {
    //       expression {
    //         (branchType == 'release')
    //       }
    //   }
    //   parallel {
    //     stage("Deploy on Prod") { 
    //       steps {
    //         script {
    //           build job: "${deploy_job_release}/${env.BRANCH_NAME.replaceAll('/', '%2F')}",
    //           propagate: false,
    //           wait: false
    //         }
    //       }
    //     }
    //     stage("Deploy on BC") { 
    //       steps {
    //         script {
    //           build job: "${deploy_bcjob_release}/${env.BRANCH_NAME.replaceAll('/', '%2F')}",
    //           propagate: false,
    //           wait: false
    //         }
    //       }
    //     }
    //   }
    // }
  }

  // post {
  //   always {
  //     sh """
  //       docker stop ${env.appname}-${env.GIT_COMMIT}
  //       docker rm ${env.appname}-${env.GIT_COMMIT}
  //       docker rmi ${env.appname}-${env.GIT_COMMIT}:latest
  //     """  
  //     cleanWs()
  //   }   
  // }
}
