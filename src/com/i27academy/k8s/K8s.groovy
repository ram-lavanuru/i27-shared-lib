package com.i27academy.k8s
class K8s {
    def jenkins
    K8s(jenkins) {
        this.jenkins = jenkins
    }
    // def build(appName) {
    //     jenkins.sh"""
    //     echo "*****builiding the $appName application"
    //     mvn clean package -DskipTests=true
    //     """
    // }
    def auth_login() {
        jenkins.sh"""
        echo "********entering into k8s authentication/login method*****"
        gcloud compute instances list
        echo "********get nodes*****"
        gcloud --version
        gcloud container clusters get-credentials i27-cluster --zone us-central1-a --project devops-project-448505
        kubectl get nodes
        """
    }

    def k8sDeploy(fileName, docker_image, namespace) {
        jenkins.sh"""
        echo "list the files"
        sed -i "s|DIT|${docker_image}|g" ./.cicd/${fileName} 
        kubectl apply -f ./.cicd/${fileName} -n ${namespace}
        """
    }

    def k8sHelmChartDeploy() {
        jenkins.sh"""
        echo ****entering into helm deployments****
        helm version
        """
    }
}