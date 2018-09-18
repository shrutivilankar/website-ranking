import React from 'react';
import {ResultsListItemContainer} from './ResultsListItemContainer.js';


export const ResultsListContainer = (props) => {	

	return (
		<div className="text-center" >
			{
				((props.error != "") 
					? ( <div id="noResults"> <h5 className="alert alert-danger"> Error occured! {props.error}</h5></div>) 
						:	((props.searchResult.length == 0 )
						? <div id="noResults"> <h5>No Results Found</h5></div> 
						: props.searchResult.map(
										(resultItem, index) =>	
										(<ResultsListItemContainer key= {index} rank={++index} website={resultItem} /> )
										)))
					
			}
		</div>
		);
	

}