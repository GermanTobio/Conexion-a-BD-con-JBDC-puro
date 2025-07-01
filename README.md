# 🏫 Conexión JDBC a la Base de Datos `centroseducacioninfantil`

Este proyecto Java realiza una conexión mediante **JDBC puro** a una base de datos **MySQL** llamada `centroseducacioninfantil`. La aplicación es de tipo consola (terminal) y permite consultar información básica sobre educadores y guarderías.

---

## ⚙️ Tecnologías utilizadas

- **Java SE**
- **JDBC**
- **MySQL**
- **MySQL Connector/J**
- **IDE utilizado:** NetBeans

---

## 📦 Estructura del proyecto

Este proyecto incluye:

- Código Java para realizar la conexión y las consultas a la base de datos.
- Un menú interactivo en consola con 3 opciones principales.
- Uso de `PreparedStatement` para evitar inyecciones SQL.

---

## 📋 Menú de opciones

Al ejecutar el programa, se muestra un menú con las siguientes tres opciones:

1. **Mostrar educadores y su guardería**  
   Muestra el nombre de cada educador y el nombre de la guardería donde trabaja.

2. **Cantidad de trabajadores por guardería**  
   Muestra el nombre de cada guardería y la cantidad total de trabajadores asociados.

3. **Gasto total en salarios por guardería**  
   Muestra el nombre de cada guardería y el total de dinero que se gasta en los salarios de sus trabajadores.

---

## 🗄️ Requisitos previos

- Tener una base de datos MySQL activa llamada `centroseducacioninfantil`.
- La base debe contener las tablas necesarias para que funcionen las consultas (educadores, guarderías, relaciones, salarios, etc.).
- Tener el archivo `.jar` del **MySQL Connector/J** agregado al classpath del proyecto (archivo facilitado en la carpeta raiz del proyecto).

---

## 📌 Notas
Este proyecto está pensado como una demostración básica del uso de JDBC sin frameworks adicionales.

---

## 🧑‍💻 Autor
Germán Ariel Tobio Antonelli
