import React from 'react';
import {ResultsListItemContainer} from './ResultsListItemContainer.js';


export const ResultsListContainer = (props) => {	

	return (
		<div className="text-center">
			{
				(props.searchResult.length == 0 )
						? <div id="noResults"> <h5>No Results Found</h5></div> 
						: props.searchResult.map(
										(resultItem, index) =>	
										(<ResultsListItemContainer rank={++index} website={resultItem} /> )
										)
			}
		</div>
		);
	

}