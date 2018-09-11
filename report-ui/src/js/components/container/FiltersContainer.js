import React from 'react';
import {ResultsListContainer} from './ResultsListContainer.js';
import axios from 'axios';
import Datetime from 'react-datetime';
import moment from 'moment';


const api_url = process.env.API_URL || '';

export class FiltersContainer extends React.Component{
	constructor(props){
		super(props);
		this.limit = 5;
		this.date = "";			
		this.sortBy = "";
		this.state = {			
			//query : "",
			queryResult : []
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
		//this.setState({date : event.target.value});
		this.date =  event.target.value;
		this.buildQuery();
	}

	handleSortOption(event){
		//this.setState({sortBy : event.target.value});
		this.sortBy = event.target.value;
		this.buildQuery();

	}
	handleLimitChange(event){
		this.limit = event.target.value;
		/*this.setState(function(state,props){
			return {limit : event.target.value};
		});*/
		this.buildQuery();

	}

	search(queryString){
		//const userEnteredDate = event.target.valueAsDate;

		//const newDate = Date.UTC(userEnteredDate.getUTCFullYear(), userEnteredDate.getUTCMonth(), userEnteredDate.getUTCDate(), 0, 0, 0);
		console.log('in search moment -  ' + queryString);
		//const queryString  = this.state.query + "date=" + event.target.value + "&limit=5&sortBy=LeastVisits";
		const url = api_url +"/websites" +queryString;
		 axios.get(url)
			  .then(({data}) => {
			  	console.log(data);
			  	console.log(data.data);
			  	this.setState(function(state,props){
			  		return {queryResult : data};
			  	});
			  	
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
							<select name="Limit"  onChange={this.handleLimitChange} >
							  <option value="5">5</option>
							  <option value="3">3</option>
							  <option value="10">10</option>								
							</select>							
						</div>
					</div>
				</nav>	
				<ResultsListContainer searchResult={this.state.queryResult}/>
				
			</div>);
			
	}

}