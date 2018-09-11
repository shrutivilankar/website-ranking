import React from 'react';
import {TitleContainer} from './TitleContainer.js';
import {FiltersContainer} from './FiltersContainer.js';

export class HeaderContainer extends React.Component{
	render(){
		return (
			<div >
				<TitleContainer />
				<FiltersContainer/>
			</div>
			);
	}

};