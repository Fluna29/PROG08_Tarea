Descripción funcional
El objetivo de esta tarea es desarrollar una pequeña aplicación de gestión documental para una biblioteca que nos permita consultar los libros del catálogo, dar de alta, editar y modificar los existentes.

Cuando el programa se inicie mostrará un menú por la consola del sistema con las siguientes opciones:

1. Mostrar listado completo de libros

2. Dar de alta un nuevo libro

3. Editar un libro existente

4. Dar de baja un libro existente

5. Buscar libro por título

6. Buscar libro por año de publicación

7. Mostrar listado de libros ordenado por título

8. Mostrar listado de libros ordenado por año de publicación y autor

9. Salir

El usuario podrá seleccionar cualquier de las opciones anteriores introduciendo el número correspondiente a dicha opción. Tras acceder a esa opción y usar la funcionalidad de esa opcion se volverá mostrar el menú permitiendo escoger una nueva opción. La única excepción es la opción Salir que directamente finalizará el programa.

Inicialmente el catálogo de libros del programa nada más iniciarse ya tendrá la información de 5 libros que el alumno elegirá libremente.

A continuación se describe lo que debe hacer cada una de las opciones del menú:

1. Mostrar listado completo de libros
Cuando se seleccione esta opción se mostrar por la consola todas la información de todos los libros actualmente existentes en el catálogo. La información se mostrará de forma que en una línea diferente irá la información de un libro en el formato “dato: valor”. Por ejemplo: “Título: 100 años de soledad. Autor: García Márquez, Gabriel” (seguiría con el resto de información)

2. Dar de alta un nuevo libro
Con esta opción se solicitará por consola primero el ISBN del nuevo libro que se quiere dar de alta. Si ya existe un libro con ese ISBN se mostrará un mensaje de error y se indicará que no se puede dar de alta por este motivo. Si no, se irán pidiendo todos los datos necesarios de un libro por consola y se dará de alta.

3. Editar un libro existente
Con esta opción se solicitará por consola primero el ISBN del libro que se quiere editar. Si ya existe un libro con ese ISBN se irán solicitando todos los datos restantes del libro por consola y una vez introducidos todos se actualizará. Si no existe ningún libro con ese ISBN, se mostrará un mensaje de error.

4. Dar de baja un libro existente
Con esta opción se solicitará por consola primero el ISBN del libro que se quiere dar de baja. Si no existe un libro con ese ISBN se mostrará un mensaje de error al usuario. Si por el contrario si que existe, se mostrará un mensaje de confirmación indicando si está seguro de que se quiere borrar el libro con ISBN xxxx y Título yyyy (donde xxxx e yyyy son el ISBN y título del libro respectivamente). Si el usuario responde con la letra s el libro se borrará. De lo contrario, se dejará en el catálogo.

5. Buscar libro por título
Con esta opción se solicitará al usuario un texto para realizar una búsqueda de todos aquellos libros que contengan dicho texto en alguna parte del título. No se tendrá en cuenta mayúsculas ni minúsculas y se mostrará un listado de los libros encontrados como el de la opción 1. Si no se encuentra ningún libro se mostrará un mensaje por consola informando al usuario.

6. Buscar libro por año de publicación
Con esta opción se solicitará al usuario un año para buscar todos aquellos libros cuyo año de publicación coincida con el introducido monstrándose un listado de los libros encontrados como el de la opción 1. Si no se encuentra ningún libro se mostrará un mensaje por consola informando al usuario.

7. Mostrar listado de libros ordenado por título
Se mostrará un listado de libros igual al de la opción 1 pero ordenados alfabéticamente por título (sin tener en cuenta mayúsculas ni minúsculas).

8. Mostrar listado de libros ordenado por año de publicación y autor
Se mostrará un listado de libros igual al de la opción 1 pero ordenados por año de publicación de menor a mayor y dentro de los libros publicados en el mismo año alfabéticamente por apellido y nombre del autor.

9. Salir
Finalizará el programa.

Descripción técnica
La clase Libro permitirá almacenar la información de todos los libros del catálogo de la biblioteca. Los campos/atributos que tendrá serán:

ISBN

título

año de publicación

autor

género

sinopsis

Autor será un objeto de la clase Persona que solamente tendrá 2 campos/atributos: apellidos y nombre. El resto de campos serán tipos de datos básicos que tendrás que decidir cual es el más adecuado para cada uno.

La clase Catalogo almacenará todos los libros de la biblioteca en una colección de datos del tipo que tu elijas. Esta clase tendrá métodos para realizar las opciones de menú indicadas en la descripción funcional tales como: dar de alta un libro, obtener un listado de libros, etc. Habrá un método para cada opción pero puede haber todos los métodos adicionales que quieras y también campos, etc. El programa principal interactuará con un objeto de esta clase para hacer todo los que se pide para cada opción de menú.

Existirá una clase Validaciones que tendrá un método estático diferente para validar cada uno de los datos que se puedan introducir de un libro. Si un dato de los introducidos en el alta o edición de un libro no es correcto se mostrará un mensaje de error. Las validaciones son:

ISBN. Tendrá el formato como se indica aquí: https://www.bibliopos.es/manual-de-usuario-del-isbn-guia-definitiva/#google_vignette



título. Debe tener al menos 3 letras

año de publicación. Debe ser superior a 0.

autor. Debe tener un apellido de al menos 3 letras y un nombre de al menos 3 letras también y que ninguno comience por un número.

género. Debe ser alguno de estos valores: novela, ensayo o teatro.

sinopsis. Debe empezar por una letra.

Cada clase creada debe tener comentarios Javadoc en la cabecera de la clase y en la cabecera de los métodos de la misma.
