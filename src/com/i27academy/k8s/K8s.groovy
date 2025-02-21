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

    def k8sHelmChartDeploy(appName, env, helmChartPath, imageTag, namespace) {
        jenkins.sh"""
        echo ****entering into helm deployments****
        helm version
        pwd
        ls -ll
        echo ***verifying if the helm charts exits***
        if helm list -n ${namespace} | grep -i "eureka-dev-chart"; then
            echo "this hart exists"
            echo "upgrading char"
        helm upgrade ${appName}-${env}-chart -f ./.cicd/helm_values/values_${env}.yaml --set image.tag=${imageTag} ${helmChartPath} -n ${namespace}
        else
            echo "chart not exists installing the chart"
        helm install ${appName}-${env}-chart -f ./.cicd/helm_values/values_${env}.yaml --set image.tag=${imageTag} ${helmChartPath} -n ${namespace}
        fi
        """
    }
    def gitClone() {
        jenkins.sh"""
        echo ***entering into git clone menthod***
        git clone -b main https://github.com/ram-lavanuru/i27-shared-lib.git
        echo ***listing files in workspace***
        ls -la
        """
    }
}