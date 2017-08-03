#################### Logging ####################
https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
Just put a logback.xml in the root of your classpath.

#################### Encodage UTF8 ####################
Habituellement, pour gérer l'encodage du text échangé dans les trames HTTP on définit un filtre dans le web.xml sans quoi les caractères accentués seront déformés.
Avec Spring boot, il suffit de définir les propriétés de ce filtre dans application.properties

#################### i18n ############################
Il suffit de définir le fichier de traduction dans application.properties
Pour une configuration plus fine il faut instancier ReloadableResourceBundleMessageSource dans la Configuration :
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:locale/messages");
        messageSource.setCacheSeconds(60); //refresh cache once per minute
        return messageSource;
    }

#################### Utiliser les methode PUT, DELETE... dans les form html ####################
https://stackoverflow.com/questions/34048617/spring-boot-how-to-use-hiddenhttpmethodfilter
<input type="hidden" name="_method" value="put"/> dans le form, Spring MVC gère le reste.

#################### Appliquer une stratégie de correspondance des noms physiques SQL avec les propriétés et classes JAVA ##############
dans application.properties :
spring.jpa.hibernate.naming.physical-strategy=com.proto.dao.CustomPhysicalNamingStrategy

################### Gestion des transaction hibernate ####################
Avec Hibernate, grace à SessionFactory on fabrique une session qu'il faut ouvrir et qui permet de commencer une transaction,
cette dernière doit être commiter et finalement fermer la session.
Spring gère toutes ces opérations grace à l'AOP avec l'annotation @Transactional sur la méthode du service à condition
d'instantier sessionFactory dans la Configuration et de l'injecter dans le service:
Spring ouvre la session et commence la transaction avant l'execution de la méthode.
Dans la méthode, on peut récupérer la session avec sessionFactory.getCurrentSession().
Spring se charge ensuite de commiter la transaction et de fermer la session à la fin de l'execution de la méthode.

#TODO: spring security