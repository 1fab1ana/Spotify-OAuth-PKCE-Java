1. Revisiones de Estado y Archivos
   Estos comandos te permiten inspeccionar qué está pasando en tu copia local antes de realizar cualquier cambio permanente.

git status: El comando más importante. Muestra qué archivos han sido modificados, cuáles están listos para guardarse (staged) y cuáles no están siendo rastreados por Git.

git diff: Muestra línea por línea los cambios exactos que has hecho en los archivos que aún no has pasado al área de preparación.

git ls-files: Lista todos los archivos que actualmente están bajo el control de versiones de Git.

2. Preparación y Guardado (Commits)
   Este es el proceso de crear "puntos de control" en la historia de tu proyecto.

git add <nombre_archivo>: Añade un archivo específico al área de preparación (staging).

git add .: Añade todos los cambios detectados en la carpeta actual al área de preparación.

git commit -m "mensaje": Crea un nuevo punto en el historial con todos los archivos que estaban en el área de preparación. El mensaje debe ser una descripción técnica y breve de lo que hiciste.

git commit --amend: Permite corregir el último commit realizado (por si olvidaste añadir un archivo o te equivocaste en el mensaje).

3. Sincronización con el Servidor (Push & Remote)
   Comandos para enviar tu trabajo local a GitHub o verificar la conexión con la nube.

git remote -v: Muestra la URL del repositorio remoto (GitHub) al que estás conectado.

git push origin <nombre_rama>: Envía tus commits locales a la rama especificada en el servidor remoto.

git push -u origin main: Sincroniza tu rama local con la remota por primera vez, estableciendo una relación de seguimiento permanente.

git fetch: Descarga la información del servidor remoto pero sin modificar tus archivos locales (solo para ver qué han hecho otros).

4. Gestión de Ramas (Branches)
   Las ramas permiten trabajar en diferentes líneas de tiempo o funciones sin afectar el código principal.

git branch: Lista todas las ramas locales. La que tiene el asterisco * es en la que estás trabajando.

git branch -a: Lista tanto las ramas locales como las que existen en el servidor (remotas).

git checkout -b <nueva_rama>: Crea una nueva rama y te mueve automáticamente a ella.

git switch <nombre_rama>: Cambia de una rama a otra (en versiones de Git superiores a la 2.23).

5. Historial y Recuperación
   Para auditar lo que ha pasado en el tiempo o deshacer errores.

git log --oneline: Muestra una lista simplificada y cronológica de todos los commits, con su código identificador (Hash) y mensaje.

git checkout <hash_commit>: Te permite viajar en el tiempo para ver cómo estaba el código en un commit específico.

git restore <archivo>: Deshace los cambios locales en un archivo y lo devuelve al estado que tenía en el último commit.