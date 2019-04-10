window.onload = (ev) => {
    if (window.location.href === "http://localhost:8080/dashboard") {
        fetch("/api/project").then(response => {
            response.json().then(data => {
                console.log(data);
            })
        })
    }
};