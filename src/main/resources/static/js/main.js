let milestoneCheckboxes = document.querySelectorAll(".onoffswitch-checkbox");
if (milestoneCheckboxes) {
    milestoneCheckboxes.forEach(checkbox => {
        checkbox.addEventListener("click", event => {
            let milestoneId = event.target.id;
            let projectId = event.target.getAttribute("data");
            fetch(`/project/view/${projectId}/milestone/edit/${milestoneId}`).then(response => {
                response.json().then(data => {
                    console.log(data);
                })
            })
        })
    });
}