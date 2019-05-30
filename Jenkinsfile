pipeline{
	
		agent {
			label 'Slave_Induccion'
		}
	
        
		triggers {
        	pollSCM('@hourly')
		}
	
	
		options {
			buildDiscarder(logRotator(numToKeepStr: '5'))
			disableConcurrentBuilds()
		}
		
		tools {
			jdk 'JDK8_Centos' 
			gradle 'Gradle5.0_Centos' 
		}	
					
		stages{
						
			stage('Checkout') {
				steps {
                	echo '------------>Checkout - Git parqueadero<------------'
                	checkout([$class: 'GitSCM', 
                	branches: [[name: '*/master']], 
                	doGenerateSubmoduleConfigurations: false, 
                	extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'parqueadero']], 
                	gitTool: 'Git_Centos', submoduleCfg: [], 
                	userRemoteConfigs: [[credentialsId: 'GitHub_chuchodavidgomez', url: 'https://github.com/chuchodavidgomez/estacionamiento_adn_ceiba']]])
				}
			}
				
			stage('Checkout-comun') {
				steps {
                	echo '------------>Checkout - Git Comun<------------'

                	checkout([$class: 'GitSCM', 
                	branches: [[name: '*/master']], 
                	doGenerateSubmoduleConfigurations: false, 
                	extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'Comun']], 
                	gitTool: 'Git_Centos', submoduleCfg: [], 
                	userRemoteConfigs: [[credentialsId: 'GitHub_chuchodavidgomez', url: 'https://github.com/chuchodavidgomez/estacionamiento_adn_ceiba']]])
				}
			}				
			
			stage('Build') {//listo
				steps{
					echo "------------>Build<------------"
					sh 'gradle --b ./parqueadero/build.gradle build -x test'
				}
			}
			
			stage('Unit Test'){//listo
				steps{
					echo "------------>Unit Tests<------------"
					sh 'gradle --b ./parqueadero/comando/comando-dominio/build.gradle build'
					sh 'gradle --b ./parqueadero/comando/comando-dominio/build.gradle jacocoTestReport'
				}
			}
			
			stage('Static Code Analysis'){//listo
				steps{
					withEnv(['JAVA_HOME=/opt/Java/jdk1.8.0_51/']) {
						withSonarQubeEnv('Sonar') {
							echo '------------>Analisis de codigo estatico<------------'					
							sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties" 
					    }		
					}
								  					
				}
			}
														
		}
		
		post {
			failure {
				echo "----------fallo-----------"
				mail(to: 'jesus.gomez@ceiba.com.co',
				subject: "fallo Pipeline:${currentBuild.fullDisplayName}",
				body:"Something is wrongwith ${env.BUILD_URL}")				
			}
			
			success {
				echo 'This will run only if successful'
				//junit '/build/test-results/test/*.xml'
			}
		}	
			
}