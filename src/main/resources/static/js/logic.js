function sendSaveStudent() {
    var name = $("#stu-name").val();
    var alter = parseInt($("#stu-alter").val());

    $.ajax({
        url: "http://localhost/student/save",
        type: "POST",
        data: {
            name: name,
            alter: alter
        },
        async: false
    });

    window.location = "http://" + location.hostname;
}

function sendSaveProjekt() {
    var name = $("#pro-name").val();
    var text = $("#pro-text").val();

    $.ajax({
        url: "http://localhost/projekt/save",
        type: "POST",
        data: {
            name: name,
            beschreibung: text
        },
        async: false
    });

    window.location = "http://" + location.hostname;
}

function sendAssignStudent() {
    var student = parseInt($("#ass-student").val());
    var projekt = parseInt($("#ass-projekt").val());
    var start = new Date($("#ass-start").val()).toISOString().substring(0, 10);
    var end = new Date($("#ass-end").val()).toISOString().substring(0, 10);

    $.ajax({
        url: "http://localhost/student/assign",
        type: "POST",
        data: {
            studentID: student,
            projektID: projekt,
            start: start,
            end: end
        },
        async: false
    });

    window.location = "http://" + location.hostname;
}

function sendDeleteStudent(name) {
    $.ajax({
        url: "http://localhost/student/delete",
        type: "POST",
        data: {
            name: name
        },
        async: false
    });

    window.location = "http://" + location.hostname;
}

function sendDeleteProjekt(name) {
    $.ajax({
        url: "http://localhost/projekt/delete",
        type: "POST",
        data: {
            name: name
        },
        async: false
    });

    window.location = "http://" + location.hostname;
}


var viz;

function draw() {
    var config = {
        container_id: "viz",
        server_url: "bolt://localhost:7687",
        server_user: $("#viz").attr("user"),
        server_password: $("#viz").attr("pw"),
        labels: {
            "Student": {
                "caption": "name",
                "size": "pagerank",
                "sizeCypher": "MATCH (n) WHERE id(n) = {id} MATCH (n)-[r]-() RETURN sum(r.weight) AS c"
            },
            "Projekt": {
                "caption": "name",
                "size": "pagerank",
                "sizeCypher": "MATCH (n) WHERE id(n) = {id} MATCH (n)-[r]-() RETURN sum(r.weight) AS c"
            }
        },
        relationships: {
            "WORKS_ON": {
                "thickness": "count",
                "caption": false
            }
        },
        arrows: true,
        initial_cypher: "Match (n), ()-[w:WORKS_ON]-() return n,w"
    };
    viz = new NeoVis.default(config);
    viz.render();
    console.log(viz);
}


$("#stu-submit").click(function () {
    sendSaveStudent();
});

$("#pro-submit").click(function () {
    sendSaveProjekt();
});

$("#ass-submit").click(function () {
    sendAssignStudent();
});

$(".rm-student").click(function () {
    var name = $(this).parent().siblings()[0].innerHTML;
    sendDeleteStudent(name);
});

$(".rm-projekt").click(function () {
    var name = $(this).parent().siblings()[0].innerHTML;
    sendDeleteProjekt(name);
});