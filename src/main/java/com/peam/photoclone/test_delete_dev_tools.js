(async function deletePhoto(id) {
    await fetch("http://localhost:8080/photoz/" + id, {
        method: "DELETE"
    })
})("5");