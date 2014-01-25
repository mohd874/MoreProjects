if(!dojo._hasResource["dojox.highlight.languages.pygments.css"]){ //_hasResource checks added by build. Do not use _hasResource directly in your code.
dojo._hasResource["dojox.highlight.languages.pygments.css"] = true;
dojo.provide("dojox.highlight.languages.pygments.css");

dojo.require("dojox.highlight._base");
dojo.require("dojox.highlight.languages.pygments._html");

(function(){
	var dh = dojox.highlight, dhl = dh.languages;
	dhl.css = {
		defaultMode: {
			lexems: ["\\b[a-zA-Z0-9]+\\b", "\\b@media\b"],
			keywords: {
				"keyword": {
					"@media": 1
				},
				"name tag": dhl.pygments._html.tags
			},
			contains: [
				"comment",
				"string single", "string double",
				"punctuation",
				"name decorator", "name class", "name function",
				"_content"
			]
		},
		modes: [
			// comments
			{
				className: "comment",
				begin: "/\\*", end: "\\*/",
				relevance: 0
			},
			{
				className: "comment preproc",
				begin: "@[a-z][a-zA-Z]*", end: "^"
			},
			{
				className: "comment preproc",
				begin: "\\!important\\b", end: "^"
			},

			// numbers
			{
				className: "number",
				begin: "\\#[a-fA-F0-9]{3}\\b", end: "^",
				relevance: 0
			},
			{
				className: "number",
				begin: "\\#[a-fA-F0-9]{6}\\b", end: "^",
				relevance: 0
			},
			{
				className: "number",
				begin: "[\\.\\-]?[0-9]*[\\.]?[0-9]+(em|px|\\%|pt|pc|in|mm|cm|ex)", end: "^",
				relevance: 0
			},
			{
				className: "number",
				begin: "\\-?[0-9]+", end: "^",
				relevance: 0
			},

			// strings
			{
				className: "string single",
				begin: "'", end: "'",
				illegal: "\\n",
				relevance: 0
			},
			{
				className: "string double",
				begin: '"', 
				end: '"',
				illegal: "\\n",
				relevance: 0
			},
			
			// operators
			{
				className: "operator",
				begin: "[~\\^\\*!%&\\[\\]\\(\\)<>\\|+=@:;,./?-]", end: "^",
				relevance: 0
			},

			// punctuations
			{
				className: "punctuation",
				begin: "[\\[\\]();]+", end: "^",
				relevance: 0
			},
			
			// names
			{
				className: "name decorator",
				begin: "\\:[a-zA-Z0-9_\\-]+\\b", end: "^"
			},
			{
				className: "name class",
				begin: "\\.[a-zA-Z0-9_\\-]+\\b", end: "^"
			},
			{
				className: "name function",
				begin: "\\#[a-zA-Z0-9_\\-]+\\b", end: "^"
			},
			{
				className: "_content",
				begin: "\\{", end: "\\}",
				lexems: ["\\b[a-zA-Z\\-]+\\b"],
				keywords: {
					"keyword": {
						"azimuth": 1, "background-attachment": 1, "background-color": 1,
						"background-image": 1, "background-position": 1, "background-repeat": 1,
						"background": 1, "border-bottom-color": 1, "border-bottom-style": 1,
						"border-bottom-width": 1, "border-left-color": 1, "border-left-style": 1,
						"border-left-width": 1, "border-right": 1, "border-right-color": 1,
						"border-right-style": 1, "border-right-width": 1, "border-top-color": 1,
						"border-top-style": 1, "border-top-width": 1, "border-bottom": 1,
						"border-collapse": 1, "border-left": 1, "border-width": 1, "border-color": 1,
						"border-spacing": 1, "border-style": 1, "border-top": 1, "border": 1, "caption-side": 1,
						"clear": 1, "clip": 1, "color": 1, "content": 1, "counter-increment": 1, "counter-reset": 1,
						"cue-after": 1, "cue-before": 1, "cue": 1, "cursor": 1, "direction": 1, "display": 1,
						"elevation": 1, "empty-cells": 1, "float": 1, "font-family": 1, "font-size": 1,
						"font-size-adjust": 1, "font-stretch": 1, "font-style": 1, "font-variant": 1,
						"font-weight": 1, "font": 1, "height": 1, "letter-spacing": 1, "line-height": 1,
						"list-style-type": 1, "list-style-image": 1, "list-style-position": 1,
						"list-style": 1, "margin-bottom": 1, "margin-left": 1, "margin-right": 1,
						"margin-top": 1, "margin": 1, "marker-offset": 1, "marks": 1, "max-height": 1, "max-width": 1,
						"min-height": 1, "min-width": 1, "opacity": 1, "orphans": 1, "outline": 1, "outline-color": 1,
						"outline-style": 1, "outline-width": 1, "overflow": 1, "padding-bottom": 1,
						"padding-left": 1, "padding-right": 1, "padding-top": 1, "padding": 1, "page": 1,
						"page-break-after": 1, "page-break-before": 1, "page-break-inside": 1,
						"pause-after": 1, "pause-before": 1, "pause": 1, "pitch": 1, "pitch-range": 1,
						"play-during": 1, "position": 1, "quotes": 1, "richness": 1, "right": 1, "size": 1,
						"speak-header": 1, "speak-numeral": 1, "speak-punctuation": 1, "speak": 1,
						"speech-rate": 1, "stress": 1, "table-layout": 1, "text-align": 1, "text-decoration": 1,
						"text-indent": 1, "text-shadow": 1, "text-transform": 1, "top": 1, "unicode-bidi": 1,
						"vertical-align": 1, "visibility": 1, "voice-family": 1, "volume": 1, "white-space": 1,
						"widows": 1, "width": 1, "word-spacing": 1, "z-index": 1, "bottom": 1, "left": 1,
						"above": 1, "absolute": 1, "always": 1, "armenian": 1, "aural": 1, "auto": 1, "avoid": 1, "baseline": 1,
						"behind": 1, "below": 1, "bidi-override": 1, "blink": 1, "block": 1, "bold": 1, "bolder": 1, "both": 1,
						"capitalize": 1, "center-left": 1, "center-right": 1, "center": 1, "circle": 1,
						"cjk-ideographic": 1, "close-quote": 1, "collapse": 1, "condensed": 1, "continuous": 1,
						"crop": 1, "crosshair": 1, "cross": 1, "cursive": 1, "dashed": 1, "decimal-leading-zero": 1,
						"decimal": 1, "default": 1, "digits": 1, "disc": 1, "dotted": 1, "double": 1, "e-resize": 1, "embed": 1,
						"extra-condensed": 1, "extra-expanded": 1, "expanded": 1, "fantasy": 1, "far-left": 1,
						"far-right": 1, "faster": 1, "fast": 1, "fixed": 1, "georgian": 1, "groove": 1, "hebrew": 1, "help": 1,
						"hidden": 1, "hide": 1, "higher": 1, "high": 1, "hiragana-iroha": 1, "hiragana": 1, "icon": 1,
						"inherit": 1, "inline-table": 1, "inline": 1, "inset": 1, "inside": 1, "invert": 1, "italic": 1,
						"justify": 1, "katakana-iroha": 1, "katakana": 1, "landscape": 1, "larger": 1, "large": 1,
						"left-side": 1, "leftwards": 1, "level": 1, "lighter": 1, "line-through": 1, "list-item": 1,
						"loud": 1, "lower-alpha": 1, "lower-greek": 1, "lower-roman": 1, "lowercase": 1, "ltr": 1,
						"lower": 1, "low": 1, "medium": 1, "message-box": 1, "middle": 1, "mix": 1, "monospace": 1,
						"n-resize": 1, "narrower": 1, "ne-resize": 1, "no-close-quote": 1, "no-open-quote": 1,
						"no-repeat": 1, "none": 1, "normal": 1, "nowrap": 1, "nw-resize": 1, "oblique": 1, "once": 1,
						"open-quote": 1, "outset": 1, "outside": 1, "overline": 1, "pointer": 1, "portrait": 1, "px": 1,
						"relative": 1, "repeat-x": 1, "repeat-y": 1, "repeat": 1, "rgb": 1, "ridge": 1, "right-side": 1,
						"rightwards": 1, "s-resize": 1, "sans-serif": 1, "scroll": 1, "se-resize": 1,
						"semi-condensed": 1, "semi-expanded": 1, "separate": 1, "serif": 1, "show": 1, "silent": 1,
						"slow": 1, "slower": 1, "small-caps": 1, "small-caption": 1, "smaller": 1, "soft": 1, "solid": 1,
						"spell-out": 1, "square": 1, "static": 1, "status-bar": 1, "super": 1, "sw-resize": 1,
						"table-caption": 1, "table-cell": 1, "table-column": 1, "table-column-group": 1,
						"table-footer-group": 1, "table-header-group": 1, "table-row": 1,
						"table-row-group": 1, "text": 1, "text-bottom": 1, "text-top": 1, "thick": 1, "thin": 1,
						"transparent": 1, "ultra-condensed": 1, "ultra-expanded": 1, "underline": 1,
						"upper-alpha": 1, "upper-latin": 1, "upper-roman": 1, "uppercase": 1, "url": 1,
						"visible": 1, "w-resize": 1, "wait": 1, "wider": 1, "x-fast": 1, "x-high": 1, "x-large": 1, "x-loud": 1,
						"x-low": 1, "x-small": 1, "x-soft": 1, "xx-large": 1, "xx-small": 1, "yes": 1
					},
					"name builtin": {
						"indigo": 1, "gold": 1, "firebrick": 1, "indianred": 1, "yellow": 1, "darkolivegreen": 1,
						"darkseagreen": 1, "mediumvioletred": 1, "mediumorchid": 1, "chartreuse": 1,
						"mediumslateblue": 1, "black": 1, "springgreen": 1, "crimson": 1, "lightsalmon": 1, "brown": 1,
						"turquoise": 1, "olivedrab": 1, "cyan": 1, "silver": 1, "skyblue": 1, "gray": 1, "darkturquoise": 1,
						"goldenrod": 1, "darkgreen": 1, "darkviolet": 1, "darkgray": 1, "lightpink": 1, "teal": 1,
						"darkmagenta": 1, "lightgoldenrodyellow": 1, "lavender": 1, "yellowgreen": 1, "thistle": 1,
						"violet": 1, "navy": 1, "orchid": 1, "blue": 1, "ghostwhite": 1, "honeydew": 1, "cornflowerblue": 1,
						"darkblue": 1, "darkkhaki": 1, "mediumpurple": 1, "cornsilk": 1, "red": 1, "bisque": 1, "slategray": 1,
						"darkcyan": 1, "khaki": 1, "wheat": 1, "deepskyblue": 1, "darkred": 1, "steelblue": 1, "aliceblue": 1,
						"gainsboro": 1, "mediumturquoise": 1, "floralwhite": 1, "coral": 1, "purple": 1, "lightgrey": 1,
						"lightcyan": 1, "darksalmon": 1, "beige": 1, "azure": 1, "lightsteelblue": 1, "oldlace": 1,
						"greenyellow": 1, "royalblue": 1, "lightseagreen": 1, "mistyrose": 1, "sienna": 1,
						"lightcoral": 1, "orangered": 1, "navajowhite": 1, "lime": 1, "palegreen": 1, "burlywood": 1,
						"seashell": 1, "mediumspringgreen": 1, "fuchsia": 1, "papayawhip": 1, "blanchedalmond": 1,
						"peru": 1, "aquamarine": 1, "white": 1, "darkslategray": 1, "ivory": 1, "dodgerblue": 1,
						"lemonchiffon": 1, "chocolate": 1, "orange": 1, "forestgreen": 1, "slateblue": 1, "olive": 1,
						"mintcream": 1, "antiquewhite": 1, "darkorange": 1, "cadetblue": 1, "moccasin": 1,
						"limegreen": 1, "saddlebrown": 1, "darkslateblue": 1, "lightskyblue": 1, "deeppink": 1,
						"plum": 1, "aqua": 1, "darkgoldenrod": 1, "maroon": 1, "sandybrown": 1, "magenta": 1, "tan": 1,
						"rosybrown": 1, "pink": 1, "lightblue": 1, "palevioletred": 1, "mediumseagreen": 1,
						"dimgray": 1, "powderblue": 1, "seagreen": 1, "snow": 1, "mediumblue": 1, "midnightblue": 1,
						"paleturquoise": 1, "palegoldenrod": 1, "whitesmoke": 1, "darkorchid": 1, "salmon": 1,
						"lightslategray": 1, "lawngreen": 1, "lightgreen": 1, "tomato": 1, "hotpink": 1,
						"lightyellow": 1, "lavenderblush": 1, "linen": 1, "mediumaquamarine": 1, "green": 1,
						"blueviolet": 1, "peachpuff": 1
					}
				},
				contains: [
					"comment", "comment preproc", 
					"number",
					"string single", "string double",
					"punctuation",
					"name decorator", "name class", "name function"
				]
			}
		]
	};
})();

}
