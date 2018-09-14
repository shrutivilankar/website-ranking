import React from 'react';
import ReactDOM from 'react-dom';
import {HeaderContainer} from './HeaderContainer.js';


export class ReportContainer extends React.Component{
	render(){
		return(<form className=" text-center">
			
					<HeaderContainer/>			
				</form>);
	}
};

ReactDOM.render(<ReportContainer/>,document.getElementById('report-form'));