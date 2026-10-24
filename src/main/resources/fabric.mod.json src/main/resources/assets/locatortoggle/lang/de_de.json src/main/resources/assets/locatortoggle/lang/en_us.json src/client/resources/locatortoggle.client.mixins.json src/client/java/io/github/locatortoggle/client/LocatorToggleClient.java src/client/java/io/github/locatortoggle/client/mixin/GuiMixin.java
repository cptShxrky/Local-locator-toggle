{
	"schemaVersion": 1,
	"id": "locatortoggle",
	"version": "${version}",
	"name": "Locator Toggle",
	"description": "Schaltet die Locator Bar per Hotkey (Standard: K) an und aus.",
	"authors": ["Jan"],
	"license": "CC0-1.0",
	"environment": "client",
	"entrypoints": {
		"client": ["io.github.locatortoggle.client.LocatorToggleClient"]
	},
	"mixins": [
		{
			"config": "locatortoggle.client.mixins.json",
			"environment": "client"
		}
	],
	"depends": {
		"fabricloader": ">=0.20.1",
		"minecraft": "~1.21.11",
		"java": ">=21",
		"fabric-api": "*"
	}
}
