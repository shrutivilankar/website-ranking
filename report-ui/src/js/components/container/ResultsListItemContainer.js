import React from 'react';

export class ResultsListItemContainer extends React.Component{
	constructor(props){
		super(props);
	}
	render(){
		const externalLink = "http://"+this.props.website.link;
		return (
			<div className="card">
  				<div className="card-body">
	  				<div className="row">
	  					<div className="col-2-2 align-items-center">
		  					<h5 className=" align-items-center"> {this.props.rank}</h5>
		  				</div>
		  				<div className="col-5 align-items-center">
		  					<p className="card-title"><a href={externalLink} >{this.props.website.link}</a> </p>
		  				</div>
		  				<div className="col-3 align-items-center">
		  					<p>visited {this.props.website.noOfVisits} times </p>
		  				</div>
		  			</div>
  				</div>
  			</div> );
		
	}

}