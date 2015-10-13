SensorLab
=========

L'objectif de ce TP est de transformer l'application SensorLab en une application client serveur.
Dans l'application SensorLab, un capteur peut être démarré, arrété, consulté.

Ce TP doit être réalisé en 4 heures. Les explications sont données avec le repository Github. Vous devez récupérer le code et faire le TP en vous aidant du cours et des ressources disponibles sur Internet. Pensez aux problèmes liés au Security Manager, au chargement du code et aux serveur de nom (RmiRegistry)

```
public interface ISensor {
    public double getValue() throws SensorNotActivated;
    public void onOff();
    public boolean getStatus();
}
```

Un client peut se connecter à un capteur, modifier son état à distance.

* Vous devez implanter cette application en utilisant des RMI.
* Vous pourrez tester cette application en démarrant plusieurs clients.

Les clients du capteurs veulent être notifiés chaque fois que le capteur est mis à jour.

* Adapter l'application en utilisant des callbacks pour que les clients reçoivent ces notifications. 
Il s'agit de mettre en place une architecture client serveur en MVC.

Pour pouvoir travailler, commencez par faire un Pull sur ce repository. Vous pourrez le modifier et le publier dans
votre propre repository ensuite. 
