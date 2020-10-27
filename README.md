# ChatBot
ChatBot oriented to a company which is dedicated to selling IT technology products and services.

Desarrolle este chatbot en el lenguaje de programación Java con una base de conocimiento en una base de datos relacional Microsoft Access, aplique lo que es el patrón de diseño de software MVC (Modelo, Vista, Controlador), y el paradigma de programación orientado a objetos entre otras buenas prácticas de desarrollo de software.

# Funciones o Métodos
Básicamente el funcionamiento de este chatbot se basa en las funciones o métodos de repuestas, los cuales se destacan los siguientes: 

Nota: Todas estas clases de “repuestas” se implementan de la interfaz “IRespuesta”, la cual contiene dos funciones o métodos fundamentales “sendRespuesta()” y “getRespuesta()”, la cual define el comportamiento de cada repuesta.

# RespuestaLike: 
esta implementación de la interfaz “IRespuesta” se basa en un tipo de consulta que ejecuta en su base de conocimiento, la cual es una consulta SQL (Structured Query Language) para buscar un patrón específico en la columna seleccionada y retorna los valores que coinciden con el parámetro recibido. 

# RespuestaExacta: 
por otro lado, esta implementación de la interfaz “IRespuesta” se basa en un tipo de consulta que ejecuta en su base de conocimiento donde el parámetro recibido debe de ser igual a columna que fue seleccionada.

# RespuestaFrecuencia: 
esta también ejecuta una consulta SQL (Structured Query Language), pero esta busca junto a la cápsula like los valores que coinciden con el parámetro recibido y los ordena por el campo “frecuencia“ de forma descendente, lo cual retorna lo posibles valores que coinciden y donde la frecuencia en mayor.

# RespuestaValoracion: 
también esta, esta ejecuta una consulta SQL (Structured Query Language), pero esta busca junto a la cápsula like los valores que coinciden con el parámetro recibido y los ordena por el campo “valoración“ de forma descendente, lo cual retorna lo posibles valores que coinciden y donde el campo  valoración en mayor.

# RespuestaCoincidencia: 
por otro lado, esta implementación de la interfaz “IRespuesta” solo utiliza la función o método “sendRespuesta()” ya que en este caso se implementa otra función o método llamada “getPorcentaje” lo cual analiza cada respuesta retornada de una consulta a su base de conocimiento de cono cimiento. Esta función o método retorna la respuesta que más coinciden a través del número mayor de porcentaje de cada respuesta retornada, es decir esta función o método retorna la respuesta que más coinciden en base a la cantidad de caracteres iguales en base a las pregunta que están registrada en su base de conocimiento.

# Herramientas, por supuesto
•	Java
•	NetBeans IDE 
•	SQL (Structured Query Language)
•	Microsoft Access
