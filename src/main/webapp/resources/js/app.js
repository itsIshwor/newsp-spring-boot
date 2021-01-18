let copy = document.querySelector(".text")
copy.innerText= new Date().getFullYear()
let error = document.querySelector(".error");

            console.log(error)
            if (error.textContent.length == 0) {
                error.style.display = 'none'
            } else {
                console.log(error.textContent)
            }