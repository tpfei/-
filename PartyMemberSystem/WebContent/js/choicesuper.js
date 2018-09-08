$(function () {
    $.ajax({
        url: "../json/orginazation.json",
        dataType: "json",
        success: choiceMenu
    })
})

function choiceMenu(data) {
    d = new dTree('d');
    $.each(data, function (i, tree) {
        d.add(0, -1, tree.treeName);
        if (tree.parentId == "null") {
            d.config.check = true;
            d.add(tree.treeId, 0, tree.treeName);
        }
        else {
            d.config.check = true;
            d.add(tree.treeId, tree.parentId, tree.treeName);
        }

    })
//document.write(d);
    document.getElementById("main").innerHTML = d;
}