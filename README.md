# SMTPrank
SMTPrank est un logiciel d'envoit de plaisanteries par e-mail.  

## Vue d'ensemble
![Vue d'ensemble](https://github.com/crabone/Teaching-HEIGVD-RES-2016-Labo-SMTP/blob/master/figures/abstract.png)

## Installation
### MockMock
Comme il n'est pas possible de se connecter directement auprès d'un serveur SMTP depuis un privé, il est conseillé d'installer un faux serveur mail, qui réceptionnera les plaisanteries. Nous utiliserons ici MockMock, attention toutefois, il est nescessaire d'avoir java 8 pré-installé.

1. Télécharger le programme ici: https://github.com/tweakers-dev/MockMock/blob/master/release/MockMock.jar?raw=true
2. Ouvrir un terminal et se rendre dans le dossier de téléchargement
3. Executer la commande suivante: java -jar MockMock.jar -p 2525

Note: Il est conseillé de mapper MockMock sur le port 2525. Sur certains systèmes d'exploitations (tel que GNU/Linux) il est nescessaire de bénéficier des droits administrateurs pour mapper MockMock sur le port 25.

### SMTPrank
A défaut d'executable, il est nescessaire de compiler l'application et de le lancé depuis un IDE (ici Netbeans)
1. Cloner le repository
2. Ouvrir le projet
3. Compiler et exécuter

## Configuration
SMTPrank est configurable par des fichiers situés dans /path/to/install/dir/config/*

## Aspects techniques
### Diagramme de classe
![Diagrame de classe](https://github.com/crabone/Teaching-HEIGVD-RES-2016-Labo-SMTP/blob/master/figures/diagrame-de-classe.png)

