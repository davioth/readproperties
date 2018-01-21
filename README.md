# **Read Properties**

Este proyecto es un ejemplo de como poder leer en un POJO Java normal, es decir no dentro del ciclo de Spring, una propiedad leída desde el application.properties mediante una calse de Configuración.

21/01/2017

## Autor

Ubay Díaz Machín

davioth@gmail.com

@Davioth

www.davioth.com

## Utiliza

- lombok 1.16.18
- Spring Starters:
  - spring-boot-starter
  - spring-boot-starter-test
  - Versión: **2.0.0.M7**
- Java 1.8
- Maven



## Ejecución

Este proyecto sólo tiene un test a ser ejecutado, que permite comprobar el concepto.

`mvn test`

## Descipción

1. Primero tenemos la clase **AppConfigProperties** que es la clase que carga la propiedades de la forma normal usada en Spring Boot, desde **application.properties**

2. Tenemos la clase **SpringContextConfigBridgeImpl** , que implementa la interfaz **SpringContextConfigBridge** y **ApplicationContextAware**. 

   - La clase **ApplicationContextAware**, es propia de Spring y permite obtener el contexto de aplicación en un Bean de forma sencilla. Con el código:

   ```java
   @Component
   public class SpringContextConfigBridgeImpl implements SpringContextConfigBridge, ApplicationContextAware {

       private static ApplicationContext applicationContext;

       @Override
       public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
           this.applicationContext = applicationContext;
       }

       @Override
       public <T> T getConfigProperties(Class<T> beanPropertie) {
           return applicationContext.getBean(beanPropertie);
       }


       public static SpringContextConfigBridge config() {
           return applicationContext.getBean(SpringContextConfigBridge.class);
       }
   }
   ```

   - Lo princial de la clase es el método estático, **config()** que nos permite obtener una instancia de este Bean de froma estática.
   - El método **getConfigProperties()** nos devuelbe el Bean indicado por la Clase que le pasemos. Este método nos permite tener por ejemplo una instancia de **AppConfigProperties**, para su uso más tarde.

3. En la clase **ClaseNoSpring** se utiliza lo indicado anterior para poder recuperar una propiedad. 

   ```java
   public class ClaseNoSpring {

       public String getPropertie() {
           return SpringContextConfigBridgeImpl.config()
                   .getConfigProperties(AppConfigProperties.class).getPruebaConcepto();
       }
   }
   ```