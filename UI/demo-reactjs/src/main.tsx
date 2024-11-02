import React from 'react';
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
//import RegisterUser from './pages/RegisterUser/index.tsx';
import Login from './pages/RegisterUser/Login/Login.tsx';
import Application from './Application.tsx';
//import App from './App.tsx';

createRoot(document.getElementById('root')!).render(
	<StrictMode>
		<Application />
	</StrictMode>,
);
