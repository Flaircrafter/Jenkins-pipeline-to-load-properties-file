def buildvars() {
    [
        artifactoryServer = '570345447@1457720246680'
        appname = 'discovery'
        ARTIFACTORY = 'b6e8618e-35aa-46dd-8a8f-72a9c374fe36'
        ARTIFACT_REPOSITORY_LOCAL = 'pfi-libs-snapshot-local'
        ARTIFACT_REPOSITORY_RELEASE = 'pfi-libs-release-local'
        REPO_PATH = '/com/prudential/fi/microservices'
        ARTIFACTORY_URL = 'https://artifactory.prudential.com/artifactory/'
        deploy_job_develop = 'pfi-services/discovery-server/discovery-server-int-deployment'
        deploy_job_release = 'pfi-services/discovery-server/discovery-server-prod-deployment'
        deploy_bcjob_release = 'pfi-services/discovery-server/discovery-server-bc-deployment'

    ]
}

return this
