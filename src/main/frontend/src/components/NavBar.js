import React from "react"
import { Switch, Route, Link } from "react-router-dom"
import Error404 from "./Error404"
import PetIndexContainer from "./PetIndexContainer"
import GroupingIndexContainer from "./GroupingIndexContainer"
// import PetTypeIndexContainer from "./PetTypeIndexContainer"
import FormsContainer from "./FormsContainer"
import PetShowContainer  from "./PetShowContainer"
import searchButton from "../functions/searchButton.js"

const NavBar = props => {
  return (
    <>
      <div className="top-bar">
        <div className="top-bar-left">
          <ul className="menu">
            <li><Link to="/" className="site-title">Dances with Pets</Link></li>
            <li><Link to="/adopt" className="vr-left navLink">Adopt</Link></li>
            <li><Link to="/surrender" className="navLink">Surrender</Link></li>
            <li className="vr-left">
              <div className="dropdown">
                <Link to="/pets" className="nav-drop">Pets</Link>
                <div className="dropdown-content">
                  <Link to="/pets">Current Pets</Link>
                  <Link to="/past-pets">Past Pets</Link>
                  <hr className="hr-slim" />
                  <Link to="/grouping/classifications">By Class</Link>
                  <Link to="/grouping/types">By Type</Link>
                  <Link to="/grouping/breeds">By Breed</Link>
                  <hr className="hr-slim" />
                  <Link to="/type/cat">Cats</Link>
                  <Link to="/type/dog">Dogs</Link>
                </div>
              </div>
            </li>
          </ul>
        </div>
        <div className="top-bar-right">
          <ul className="menu">
            <li><Link to="/employees" className="vr-right margin-right-1 navLink">Employees</Link></li>
            <li><input type="search" placeholder="Search" className="search-bar" id="search-bar" /></li>
            <li><button type="button" className="button" onClick={searchButton} id="search-button">Search</button></li>
          </ul>
        </div>
      </div>
      <div className="content">
        <Switch>
          <Route exact path="/" component={PetIndexContainer} />
          <Route exact path="/pets" component={PetIndexContainer} />
          <Route exact path="/pets/:name" component={PetShowContainer} />
          <Route exact path="/past-pets" component={PetIndexContainer} />
          <Route exact path="/classification/:classification" component={PetIndexContainer} />
          <Route exact path="/type/:type" component={PetIndexContainer} />
          <Route exact path="/breed/:breed" component={PetIndexContainer} />
          <Route exact path="/employees" component={PetIndexContainer} />
          <Route exact path="/grouping" component={GroupingIndexContainer} />
          <Route exact path="/grouping/:type" component={GroupingIndexContainer} />
          <Route exact path="/adopt" render={() => <FormsContainer form={"adoption"} />} />
          <Route exact path="/surrender" render={() => <FormsContainer form={"surrender"} />} />
          <Route exact path="/review-adoptions" render={() => <FormsContainer form={"adoption-review"} />} />
          <Route exact path="/review-surrenders" render={() => <FormsContainer form={"surrender-review"} />} />
          <Route render={() => <Error404 error={`Sorry, but that page doesn't exist on our site!`} />} />
        </Switch>
      </div>
      <div className="footer">
        <ul className="footer-content menu">
          <li className="header-links"><a href="https://launchacademy.com/" className="navLink">Launch Academy</a></li>
          <li className="header-links"><a href="https://learn.launchacademy.com/teams/boston-apprenti-3/curricula/on-campus-apprenti-3/lesson_groups/week_17:_spring_react_monoliths/lessons/java-spring-express-refactor" className="vr-left navLink">Java Spring Express Refactor</a></li>
          <li className="vr-left">
            <div className="dropup">
              <Link to="#" className="nav-drop">API</Link>
              <div className="dropup-content">
                <Link to="/api/v1/pets">Current API</Link>
                <Link to="/api/v1/past-pets">Past API</Link>
                <hr className="hr-slim" />
                <Link to="/grouping/classifications">By Class</Link>
                <Link to="/grouping/types">By Type</Link>
                <Link to="/grouping/breeds">By Breed</Link>
                <hr className="hr-slim" />
                <Link to="/api/v1/type/cat">Cats API</Link>
                <Link to="/api/v1/type/dog">Dogs API</Link>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </>
  )
}

export default NavBar