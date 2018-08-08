<!DOCTYPE html>
<html>
<head>
    <title>Application Versions</title>
    <asset:stylesheet src="bootstrap.css"/>
    <style type="text/css">

    body {
        background-color: #dadada;
    }

    h1 {
        font-family: Georgia, serif;
        font-weight: bold;
        font-size: 2em;
    }

    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-1" style="text-align: right;">
            <asset:image style="margin-top: 45px;" src="grails.svg" alt="Grails Logo"/>
        </div>
        <div class="col-md-3">
            <h1><g:meta name="info.app.name"/></h1>
            <ul class="list-group">
                <li class="list-group-item active"><b>App name:</b> <g:meta name="info.app.name"/></li>
                <li class="list-group-item"><b>App version:</b> <g:meta name="info.app.version"/> </li>
                <li class="list-group-item"><b>Environment:</b> ${grails.util.Environment.current.name}</li>
                <li class="list-group-item"><b>App profile:</b> ${grailsApplication.config.grails?.profile}</li>
                <li class="list-group-item"><b>Grails version:</b> <g:meta name="info.app.grailsVersion"/></li>

                <li class="list-group-item"><b>Groovy version:</b> ${GroovySystem.getVersion()}</li>
                <li class="list-group-item"><b>JVM version:</b> ${System.getProperty('java.version')}</li>
                <li class="list-group-item"><b>Reloading active:</b> ${grails.util.Environment.reloadingAgentEnabled}</li>
                <%--
                <li class="list-group-item"><b>Controllers:</b> ${grailsApplication.controllerClasses.size()}</li>
                <li class="list-group-item"><b>Domains:</b> ${grailsApplication.domainClasses.size()}</li>
                <li class="list-group-item"><b>Services:</b> ${grailsApplication.serviceClasses.size()}</li>
                <li class="list-group-item"><b>Tag Libraries:</b> ${grailsApplication.tagLibClasses.size()}</li>
                --%>
            </ul>
        </div>
        <div class="col-md-4">
            <h1 style="font-family: Georgia, serif; font-weight: bold; font-size: 2em;">Installed Plugins</h1>
            <table class="table table-striped">
                <tbody>
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins.sort{it.name}}">
                    <tr>
                        <td>${plugin.name}</td>
                        <td>${plugin.version}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
        <div class="col-md-4">
            &nbsp;
        </div>
    </div>
</div>
</body>
</html>