import React, { useState } from 'react';
import './App.css';

function App() {
	const [name, setName] = useState("");
	const [names, setNames] = useState<string[]>([]);

	const addNames = () => {
		console.log(names);
		setNames([...names, name]);
	}
	return (
	<>
	<div>{name}</div>
	<div>
		<input
			type="text"
			onChange={(e) => setName(e.target.value)}/>
			<button onClick={addNames}>Agregar</button>
			<ul>
				{names.map((name, index) => (
					<li key={index}>{name}</li>
				))}
			</ul>
	</div>
	</>
	);

}

export default App;