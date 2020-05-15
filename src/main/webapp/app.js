

let dataListeClients = {
	titre: "Liste des clients (vue)",
	clients: []
};

let cmpListeClients = new Vue({
	el: "#liste-clients",
	data: dataListeClients
});

let dataFormClient = {
	client: {}
};

let cmpFormClient = new Vue({
	el: "#form-client",
	data: dataFormClient,
	methods: {
		create: function(){
			
			fetch("api/clients", {
	            method: "POST",
	            headers: {"Content-Type": "application/json"},
	            body: JSON.stringify(dataFormClient.client)
	        }).then(getClients);
			
		}
	}
});

function getClients(){
	
	fetch("api/clients")
		.then(resp => resp.json())
		.then(clients => dataListeClients.clients = clients)
	;
}


getClients();