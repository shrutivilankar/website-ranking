import React from 'react';
import {ResultsListContainer} from './ResultsListContainer.js';
import axios from 'axios';


const api_url = process.env.API_URL || '';

export class FiltersContainer extends React.Component{
	constructor(props){
		super(props);
		this.limit = 5;
		this.date = "";			
		this.sortBy = "";

		this.state = {					
			queryResult : [],
			error : ""
		};
		this.search = this.search.bind(this);
		this.buildQuery = this.buildQuery.bind(this);
		this.handleDateChange = this.handleDateChange.bind(this);
		this.handleSortOption = this.handleSortOption.bind(this);
		this.handleLimitChange = this.handleLimitChange.bind(this);
		
	}
	componentDidMount(){
		this.buildQuery();		
	}
	buildQuery(){
		const q = "?date="+this.date+"&limit="+this.limit+"&sortBy="+ this.sortBy;	

		this.search(q);
	}
	handleDateChange(event){
		
		this.date =  event.target.value;
		this.buildQuery();
	}

	handleSortOption(event){
		
		this.sortBy = event.target.value;
		this.buildQuery();

	}
	handleLimitChange(event){
		this.limit = event.target.value;		
		this.buildQuery();

	}

	search(queryString){
			
		const url = api_url +"/websites" +queryString;
		 axios.get(url)
			  .then(({data}) => {
			  	
			  	this.setState(function(state,props){
			  		return {
			  			queryResult : data,
			  			error : ""
			  		};
			  	});
			  	
			  })
			  .catch((error) => {
			  	if (error.response) {

             		this.setState(function(state,props){
				  		return {error : "Internal Server Error. Trace the error using trace-id : " 
				  		+ error.response.headers.traceid};
				  	});

			  	}else if (error.request) {
		           
		            console.log(error.request);
		            this.setState(function(state,props){
				  		return {error : "Request failed. Trace the error using trace-id : " 
				  		+ error.response.headers.traceid};
				  	});
		            
		        } else {

		            this.setState(function(state,props){
				  		return {error : "Trace the error using trace-id : " 
				  		+ error.response.headers.traceid};
				  	});
		        }
			  });

	}

	render(){
		return (
			<div className="align-items-center">	
				<nav className="navbar sticky-top navbar-expand-lg navbar-light bg-light form-row align-items-center">
					<div className="col-auto">	
						<div  className="input-group">
							<div className="input-group-prepend">
								<span className="input-group-text ">Search By Date</span>
							</div>
							<input type='date' onChange={this.handleDateChange} />  								
						
						</div>	
					</div>	
					
					<div className="col-auto">	
						<div  className="input-group">
							<div className="input-group-prepend">
								<span className="input-group-text ">Sort By </span>
							</div>
							<select id="SortOption"  name="SortOption" onChange={this.handleSortOption} >
							  <option value="MostVisits">Most Visited</option>
							  <option value="LeastVisits">Least Visited</option>						 
							</select>
						</div>
					</div>
					<div className="col-auto">	

						<div  className="input-group">
							<div className="input-group-prepend">
								<span className="input-group-text ">Limit</span>
							</div>							
							<input type="number" name="Limit" min="1" step="1" placeholder="integers only" value={this.limit} onChange={this.handleLimitChange} />
							 							
						</div>
					</div>
				</nav>	
				<div id="content" >					
					<ResultsListContainer error={this.state.error} searchResult={this.state.queryResult}/>					
					
				</div>
				
			</div>);
			
	}

}